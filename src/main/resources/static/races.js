// Adil Nurmagambetov UID:415002457
const API_URL = "/api/races";

function loadRaces() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => renderRaces(data))
        .catch(error => console.error("Error loading races:", error));
}

function renderRaces(races) {
    const table = document.getElementById("raceTable");
    table.innerHTML = "";

    races.forEach(race => {
        table.innerHTML += `
            <tr>
                <td>${race.id}</td>
                <td>${race.grandPrixName}</td>
                <td>${race.circuit}</td>
                <td>${race.country}</td>
                <td>${race.raceDate}</td>
                <td>${race.season}</td>
                <td>
                    <button class="btn btn-warning btn-sm" onclick="editRace(${race.id})">Edit</button>
                    <button class="btn btn-danger btn-sm" onclick="deleteRace(${race.id})">Delete</button>
                </td>
            </tr>
        `;
    });
}

function saveRace() {
    const id = document.getElementById("raceId").value;

    const race = {
        grandPrixName: document.getElementById("grandPrixName").value,
        circuit: document.getElementById("circuit").value,
        country: document.getElementById("country").value,
        raceDate: document.getElementById("raceDate").value,
        season: Number(document.getElementById("season").value)
    };

    if (id) {
        fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(race)
        }).then(() => {
            clearForm();
            loadRaces();
        }).catch(error => console.error("Error updating race:", error));
    } else {
        fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(race)
        }).then(() => {
            clearForm();
            loadRaces();
        }).catch(error => console.error("Error creating race:", error));
    }
}

function editRace(id) {
    fetch(`${API_URL}/${id}`)
        .then(response => response.json())
        .then(race => {
            document.getElementById("raceId").value = race.id;
            document.getElementById("grandPrixName").value = race.grandPrixName;
            document.getElementById("circuit").value = race.circuit;
            document.getElementById("country").value = race.country;
            document.getElementById("raceDate").value = race.raceDate;
            document.getElementById("season").value = race.season;
        })
        .catch(error => console.error("Error loading race:", error));
}

function deleteRace(id) {
    if (confirm("Are you sure you want to delete this race?")) {
        fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        }).then(() => {
            loadRaces();
        }).catch(error => console.error("Error deleting race:", error));
    }
}

function searchRace() {
    const name = document.getElementById("searchInput").value;

    fetch(`${API_URL}/search?grandPrixName=${encodeURIComponent(name)}`)
        .then(response => response.json())
        .then(data => renderRaces(data))
        .catch(error => console.error("Error searching races:", error));
}

function clearForm() {
    document.getElementById("raceId").value = "";
    document.getElementById("grandPrixName").value = "";
    document.getElementById("circuit").value = "";
    document.getElementById("country").value = "";
    document.getElementById("raceDate").value = "";
    document.getElementById("season").value = "";
}

loadRaces();