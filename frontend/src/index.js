const tiles = document.querySelectorAll(".tile");

tiles.forEach((tile) => tile.addEventListener("click", function () {
  const tileNumber = tile.dataset.index;
  console.log('Tile clicked: ' + tileNumber);
  fetch('http://localhost:8080/game/play?tileNumber=' + tileNumber, {
    method: 'POST'
  })
    .then(response => response.json())
    .then(data => {
      console.log(data.board);
      updateBoard(data.board);
    })
    .catch(error => console.error('Error:', error));
}));

function updateBoard(boardState) {
  tiles.forEach((tile, index) => {
    tile.innerText = boardState[index];
  });
}
