from flask import Flask, request, jsonify
from flask_cors import CORS
from datetime import datetime

app = Flask(__name__)
cors = CORS(app)

PLAYER_X = 'X'
PLAYER_O = 'O'
turn = PLAYER_X

board_state = [None] * 9


@app.route('/')
def hello_world():
    now = datetime.now()
    current_time = now.strftime("%H:%M:%S")
    return f"<h1>It is backend!</h1><p>Current time: {current_time}</p><p>Board state: {board_state}</p>"


@app.route('/click_tile', methods=['POST'])
def click_tile():
    data = request.json
    return jsonify(data)


# def check_winner():
#     # Check for a winner
#     for winning_combination in winning_combinations:
#         combo = winning_combination["combo"]
#         strike_class = winning_combination["strikeClass"]
#         tile_value_1 = board_state[combo[0] - 1]
#         tile_value_2 = board_state[combo[1] - 1]
#         tile_value_3 = board_state[combo[2] - 1]

#         if tile_value_1 is not None and \
#                 tile_value_1 == tile_value_2 == tile_value_3:
#             strike.classList.add(strike_class)
#             game_over_screen(tile_value_1)
#             return

#     # Check for a draw
#     all_tile_filled_in = all(tile is not None for tile in board_state)
#     if all_tile_filled_in:
#         game_over_screen(None)


winning_combinations = [
    # rows
    {"combo": [1, 2, 3], "strikeClass": "strike-row-1"},
    {"combo": [4, 5, 6], "strikeClass": "strike-row-2"},
    {"combo": [7, 8, 9], "strikeClass": "strike-row-3"},
    # columns
    {"combo": [1, 4, 7], "strikeClass": "strike-column-1"},
    {"combo": [2, 5, 8], "strikeClass": "strike-column-2"},
    {"combo": [3, 6, 9], "strikeClass": "strike-column-3"},
    # diagonals
    {"combo": [1, 5, 9], "strikeClass": "strike-diagonal-1"},
    {"combo": [3, 5, 7], "strikeClass": "strike-diagonal-2"}
]

if __name__ == "__main__":
    app.run(port=8080, host="0.0.0.0")
