document.getElementById('nameForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent default form submission

    var playerName = document.getElementById('playerName').value;
    sendData(playerName);
});

function sendData(playerName) {
    fetch('/save_name', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({playerName: playerName})
    })
        .then(response => response.json())
        .then(data => {
            console.log('Data sent:', data);
            // Redirect or do something after sending data to backend
        })
        .catch(error => {
            console.error('Error:', error);
        });
}