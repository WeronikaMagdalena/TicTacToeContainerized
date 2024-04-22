document.addEventListener('DOMContentLoaded', function () {

    const tiles = document.querySelectorAll('.tile');
    tiles.forEach(tile => {
        tile.addEventListener('click', handleClickTile);
    });

    //Elements
    const strike = document.getElementById("strike");
    const gameOverArea = document.getElementById("game-over-area");
    const gameOverText = document.getElementById("game-over-text");
    const playAgain = document.getElementById("play-again");
    // playAgain.addEventListener("click", startNewGame);

    function handleClickTile(event) {
        if (gameOverArea.classList.contains("visible")) {
            return;
        }

        const tileNumber = event.target.getAttribute('data-index');
        console.log(`Clicked tile ${tileNumber}`);

        fetch('http://100.27.2.58:8080/click_tile', {
            method: 'POST',
            body: JSON.stringify(tileNumber),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            // then what
        })
        .catch(error => console.error('Error:', error));
    }
});