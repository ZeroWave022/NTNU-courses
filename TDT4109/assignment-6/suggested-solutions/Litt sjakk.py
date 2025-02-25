#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

def make_board (board_string):
    # alternativ løsning som løser oppgaven på én linje:
    #  board = [[board_string_1[5*x + y] if board_string_1[5*x + y] != '.' else None for y in range(5)] for x in range(5)]
    board = []
    for i in range(5):
        board.append([])
        for j in range(5):
            symbol = board_string[5*i + j]
            if symbol != '.':
                board[i].append(symbol)
            else:
                board[i].append(None)
            # alternativ til if-else:
            #  board[i][j] = symbol if symbol != '.' else None
    return board
 

#b)

def get_piece (board, x, y):
    return board[5 - y][x - 1]
 

#c)

def is_white(piece):
    if isinstance(piece, str):
        return piece.isupper()
    if piece is None:
        return False
    return False
 
 
def same_color(piece1, piece2):
    if piece1 is None or piece2 is None:
        return True
    if is_white(piece1) and not is_white(piece2):
        return False
    if not is_white(piece1) and is_white(piece2):
        return False
    return True
 
 
def get_legal_moves(board, x, y):
    boardsize = len(board)
    piece = get_piece(board, x, y)
    hvit = is_white(piece)
    sign = 1 if hvit else -1
    valid_moves = []
    if piece in ["p", "P"]:
        # sjekke det er tomt rett foran, og at bonden ikke har kommet helt over
        if not get_piece(board, x, y + sign) and y != (boardsize / 2) - (boardsize / 2) * sign:
            valid_moves.append((x, y + sign))
            # sjekke om bonden er i startposisjon, og at det er tomt TO ruter foran
            if ((y == 2 and hvit) or (y == boardsize - 1 and not hvit)) and get_piece(board, x, y + 2 * sign) is None:
                valid_moves.append((x, y + 2 * sign))
        # sjekke om bonden kan slå foran til høyre og venstre
        if x == 1:
            right_piece = get_piece(board, x + 1, y + 1 * sign)
            left_piece = None
        elif x == len(board):
            right_piece = None
            left_piece = get_piece(board, x - 1, y + 1 * sign)
        else:
            right_piece = get_piece(board, x + 1, y + 1 * sign)
            left_piece = get_piece(board, x - 1, y + 1 * sign)
        if not same_color(piece, left_piece) and left_piece is not None:
            valid_moves.append((x - 1, y + 1 * sign))
        if not same_color(piece, right_piece) and right_piece is not None:
            valid_moves.append((x + 1, y + 1 * sign))
 
    return valid_moves

