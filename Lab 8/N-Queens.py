import itertools

def remaining_positions(board, size):
    taken_rows = frozenset(x for x, y in board)
    free_rows = (x for x in range(size) if x not in taken_rows)
    taken_columns = frozenset(y for x, y in board)
    free_columns = (y for y in range(size) if y not in taken_columns)
    free_row_col = itertools.product(free_rows, free_columns)
    taken_first_diagonals = frozenset(x + y for x, y in board)
    taken_second_diagonals = frozenset(x - y for x, y in board)
    return (
        (x, y) for x, y in free_row_col
        if x + y not in taken_first_diagonals
        and x - y not in taken_second_diagonals
    )

def ordered_remaining_positions(board, size):
    if board:
        max_x = max(x for x, y in board)
    else:
        max_x = -1
    return (
        (x, y) for x, y in remaining_positions(board, size)
        if x > max_x
    )

def nqueens(size=4, board=None):
    board = board or frozenset()
    if len(board) == size:
        yield board
    for position in ordered_remaining_positions(board, size):
        new_board = board.union((position,))
        yield from nqueens(size, new_board)

def print_board(board):
    size = len(board)
    for row in range(size):
        cells = (
            "Q" if (row, col) in board else "-"
            for col in range(size)
        )
        print("".join(cells))

if __name__ == "__main__":
    size = 4
    solution_count = 0
    for solution in nqueens(size):
        solution_count += 1
        print_board(solution)
        print("*" * size)
    print("{count} solutions".format(count=solution_count))