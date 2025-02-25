#!/usr/bin/env python
# coding: utf-8

# In[ ]:


# ####################################################################
# READ THIS ! #
# #
# Players are represented as White = 1 and Black = -1 #
# White pieces are represented in uppercase letters . #
# Black pieces in lower case . #
# #
# This code accesses matrices in a m[y][x] fashion #
# #
# PS! THIS WILL NOT LOOK PRETTY IF YOU RUN IT IN IDLE ! #
# RUN IT FROM A CONSOLE ! #
# ####################################################################
import os
from copy import deepcopy as copy
letters = [' A ', ' B ', ' C ', ' D ', ' E ', ' F ', ' G ', ' H ']
numbers = [' 1 ', ' 2 ', ' 3 ', ' 4 ', ' 5 ', ' 6 ', ' 7 ', ' 8 ']
wpieces = ['PWN ', ' R ', ' K ', ' B ', 'QUE ', 'KIN ']
bpieces = [i. lower () for i in wpieces ] # This just copies the white pieces , makes them lower case and puts them into a
list
empty = ' '
helpText = "\n ######### MEGACHESS ! #########\n\nIn this game of chess ,\nplayer 1 is the owner of the upper case pieces ,\nplayer -1 is the owner of the lower case pieces .\nInput should on the format : '[ letter ][ number ]-[ letter ][ number ]',\nfor instance : a3 - b5 .\n\nWrite 'help ' at any time during a game to see this screen .\n"
# ####################################################################
# HELPER FUNCTIONS #
# ####################################################################
# This function creates , fills and returns a board
def newBoard ():
    # This part creates an empty board
    board = []
    for x in range (0,8):
        temp = []
        for y in range (0,8):
            temp . append ( empty )
        board . append ( temp )
    # This part fills the peasants
    for x in range (0, 8):
        board [1][x] = wpieces [0]
        board [6][x] = bpieces [0]
# This fills in towers , knights and bishops
    for x in range (0, 3):
        board [0][x] = wpieces [x + 1]
        board [0][7 - x] = wpieces [x + 1]
        board [7][x] = bpieces [x + 1]
        board [7][7 - x] = bpieces [x + 1]
# This fills in Kings and queens
    board [0][3] = wpieces [4]
    board [7][3] = bpieces [4]
    board [0][4] = wpieces [5]
    board [7][4] = bpieces [5]
    return board
# This function prints the board to the screen
def printBoard (board , player ):
    print ('\n')
    # this makes a beatiful string of letters , and puts it into 's'
    s = empty
    for i in range (0,len( letters )):
        if( player != 1):
            i = 7-i
        s += ' ' + letters [i]
    print (s)
    # This double loop creates a single row to print
    for y in range (0, len( board )):
        # This makes sure the current player is at the bottom of the screen
        #If it is whites turn , the board is printed upside down
        if ( player == 1):
            y = len( numbers )- y - 1
        print ( empty + " ---------------------------------")
        row = numbers [y]
        # This fills in the row with the proper pieces
        for x in range (0, len( board )):
            if ( player != 1):
                x = (7 - x)
            row += '|' + board [y][x]
        row += '|' + numbers [y]
        print (row )
    # This prints the last two rows to make it look nice
    print ( empty + " ---------------------------------")
    print (s + "\n")
# This function validates that the input is written in the correct format
def validateInput ( inputString ):
    # Check if length is proper
    if( len( inputString ) != 5):
        return False
    # Check that the string contains a dash
    if( not '-' in inputString ):
        return False
    #The ord ( char ) function gets the ASCII value of the char
    charValue = ord( inputString [0]. upper ())
    # Check that the letters are of the proper ASCII values .
    if ( charValue < 65 or charValue > 72):
        return False
    charValue = ord( inputString [3]. upper ())
    if ( charValue < 65 or charValue > 72):
        return False
    #Do the same with the numbers
    charValue = ord( inputString [1]. upper ())
    if ( charValue < 49 or charValue > 56):
        return False
    charValue = ord( inputString [4]. upper ())
    if ( charValue < 49 or charValue > 56):
        return False
    #If we get here , the string is valid
    return True
# This function parses a correct input string to two position tuples .
def parseInputToMove ( inputString ):
    # Split the string to get the two coordinates
    positions = inputString . split ('-')
    # Make upper case so it matches our letter list
    pos1 = positions [0]. upper ()
    pos2 = positions [1]. upper ()
    #Add padding to the letter , so it matches the letter list
    temp = ' ' + pos1 [0] + ' '
    fromX = letters . index ( temp )
    fromY = int( pos1 [1]) - 1
    toX = letters . index (' ' + pos2 [0] + ' ')
    toY = int( pos2 [1]) - 1
    return (fromX , fromY ), (toX , toY )
# This function wipes the console window
def wipe ():
    os. system ('cls ' if os. name == 'nt ' else 'clear ')
# ####################################################################
# LOGIC HELPER FUNTIONS #
# ####################################################################
# This function returns true if the player owns the piece at x, y.
def isOwner (board , player , x, y):
    if ( player == 1):
        pieces = wpieces
    else :
        pieces = bpieces
    if ( board [y][x] in pieces ):
        return True
    return False
# This function checks if x and y is inside the board arrays
def boundsCheck (x, y):
    if (x < 0 or x > 7 or y < 0 or y > 7):
        return False
    return True
# This function returns true , if the position is empty or belongs to the other player
def isValidMove (board , player , x, y):
    if( board [y][x] == empty ):
        return True
    elif ( isOwner (board , player * -1, x, y)):
        return True
    return False
# ################################################################
# LOGIC MOVE FUNCTIONS #
# ################################################################
# This function will return a list of tuples with the positions the pawn at x, y can move to.
def pawnMoves (board , player , x, y):
    moves = []
    otherPlayer = player * -1
    # Since player is the direction the peasant can move in , this will work
    newY = y + player
    # Check if space in front is empty
    if ( boundsCheck (x, newY ) and board [ newY ][x] == empty ):
        moves . append ((x, newY ))
    #If peasant is in starting position , we can move two spaces
    if (( player == 1 and y == 1) or ( player == -1 and y == 6)):
        if( boundsCheck (x, newY + player ) and board [ newY + player ][x] == empty ):
            moves . append ((x, newY + player ))
    # Check if we can attack either side
    newX = x - 1
    if ( boundsCheck (newX , newY ) and isOwner (board , otherPlayer , newX , newY )):
        moves . append (( newX , newY ))
    newX = x + 1
    if ( boundsCheck (newX , newY ) and isOwner (board , otherPlayer , newX , newY )):
        moves . append (( newX , newY ))
    return moves
# This will check the moves for a rook , also known as a tower
def rookMoves (board , player , x, y):
    moves = []
    otherPlayer = player * -1
    # Check moves to the right
    for newX in range (x + 1, 8):
        if ( isValidMove (board , player , newX , y)):
            moves . append (( newX , y))
            if( isOwner (board , otherPlayer , newX , y)):
                break
        else :
            #If we get here , it means this board position contains the players own piece
            break
    # Check moves to the left
    for newX in range (x - 1, -1, -1):
        if ( isValidMove (board , player , newX , y)):
            moves . append (( newX , y))
            if( isOwner (board , otherPlayer , newX , y)):
                break
        else :
            break
    # Check moves going up
    for newY in range (y - 1, -1, -1):
        if ( isValidMove (board , player , x, newY )):
            moves . append ((x, newY ))
            if ( isOwner (board , otherPlayer , x, newY )):
                break
        else :
            break
    # Check moves going down
    for newY in range (y + 1, 8):
        if ( isValidMove (board , player , x, newY )):
            moves . append ((x, newY ))
            if ( isOwner (board , otherPlayer , x, newY )):
                break
        else :
            break
    return moves
# Returns a list of tuples , which are the valid positions a knight on x, y can go to
def knightMoves (board , player , x, y):
    moves = []
    otherplayer = player * -1
    # Check moves to the right
    newX = x + 2
    newY = y + 1
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newY = y - 1
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    # Check moves going up
    newX = x + 1
    newY = y - 2
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x - 1
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    # Check moves to the left
    newX = x - 2
    newY = y + 1
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newY = y - 1
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    # Check down moves
    newX = x + 1
    newY = y + 2
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x - 1
    if ( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    return moves
# This will give a list of tuples , containing the possible moves for a bishop
def bishopMoves (board , player , x, y):
    moves = []
    otherPlayer = player * -1
    # This variable will equal the longest diagonal
    maxSteps = min(8 - x, 8 - y)
    # Check down / right diagonal
    for i in range (1, maxSteps ):
        newX = x + i
        newY = y + i
        if ( isValidMove (board , player , newX , newY )):
            moves . append (( newX , newY ))
            if ( isOwner (board , otherPlayer , newX , newY )):
                break
        else :
            break
    # Check up/ right moves
    maxSteps = min(8 - x, y + 1)
    for i in range (1, maxSteps ):
        newX = x + i
        newY = y - i
        if ( isValidMove (board , player , newX , newY )):
            moves . append (( newX , newY ))
            if ( isOwner (board , otherPlayer , newX , newY )):
                break
        else :
            break
    # Check up/ left moves
    maxSteps = min(x + 1, y + 1)
    for i in range (1, maxSteps ):
        newX = x - i
        newY = y - i
        if ( isValidMove (board , player , newX , newY )):
            moves . append (( newX , newY ))
            if ( isOwner (board , otherPlayer , newX , newY )):
                break
        else :
            break
    # Check down / left moves
    maxSteps = min(x + 1, 8 - y)
    for i in range (1, maxSteps ):
        newX = x - i
        newY = y + i
        if ( isValidMove (board , player , newX , newY )):
            moves . append (( newX , newY ))
            if ( isOwner (board , otherPlayer , newX , newY )):
                break
        else :
            break
    return moves
# Returns all valid moves for queens
def queenMoves (board , player , x, y):
    return bishopMoves (board , player , x, y) + rookMoves (board , player , x, y)
# Returns all valid moves for kings
def kingMoves (board , player , x, y):
    moves = []
    newX = x + 1
    newY = y
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x + 1
    newY = y - 1
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x
    newY = y - 1
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x - 1
    newY = y - 1
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x - 1
    newY = y
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x - 1
    newY = y + 1
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x
    newY = y + 1
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    newX = x + 1
    newY = y + 1
    if( boundsCheck (newX , newY ) and isValidMove (board , player , newX , newY )):
        moves . append (( newX , newY ))
    return moves
# Returns all the moves for the piece in position x, y
def getMoves (board , player , x, y):
    piece = board [y][x]
    # make string uppercase , for fewer comparisons
    piece = piece . upper ()
    # Checks if it is a pawn
    if ( piece == wpieces [0]):
        return pawnMoves (board , player , x, y)
# Rook
    elif ( piece == wpieces [1]):
        return rookMoves (board , player , x, y)
# Knight
    elif ( piece == wpieces [2]):
        return knightMoves (board , player , x, y)
# Bishop
    elif ( piece == wpieces [3]):
        return bishopMoves (board , player , x, y)
# Queen
    elif ( piece == wpieces [4]):
        return queenMoves (board , player , x, y)
# King
    elif ( piece == wpieces [5]):
        return kingMoves (board , player , x, y)
#If we get here , somthing has gone horribly wrong
    else :
        return [" Horribly Wrong !"]
# ################################################################
# LOGIC GAME FUNCTIONS #
# ################################################################
# Moves a piece from fromTuple to toTuple on board
def movePiece (board , fromTuple , toTuple ):
    oldX , oldY = fromTuple [0], fromTuple [1]
    newX , newY = toTuple [0], toTuple [1]
    board [ newY ][ newX ] = board [ oldY ][ oldX ]
    board [ oldY ][ oldX ] = empty
    return board
# This function will tell if a player is in check on the provided board
def isCheck (board , player ):
    # Find out which king is the players king
    king = bpieces [5]
    if( player == 1):
        king = wpieces [5]
    kingPosition = (-1, -1)
    pressuredPositions = []
    otherPlayer = player * -1
# Make list of positions other player pressures , and find our king
    for y in range (0,8):
        for x in range (0,8):
        # This finds the king
            if ( board [y][x] == king ):
                kingPosition = (x, y)
            # This finds the pressured positions
            elif ( isOwner (board , otherPlayer , x, y)):
                pressuredPositions += getMoves (board , otherPlayer , x, y)
    # Check if the players king position is in the pressuredPositions
    if kingPosition in pressuredPositions :
        return True
    return False
# Returns true if player is in checkmate
def isCheckMate (board , player ):
    otherPlayer = player * -1
    #Try every single move possible for player
    for y in range (0, 8):
        for x in range (0, 8):
            # Check if player owns this piece
            if ( isOwner (board , player , x, y)):
                #Get all moves this piece can do
                moves = getMoves (board , player , x, y)
                # Make all moves
                for move in moves :
                    #We need to copy the board , so moves don 't overwrite the current board
                    boardCopy = copy ( board )
                    movePiece ( boardCopy , (x, y), move )
                    #If we are not in check after a move , it is not checkmate
                    if( not isCheck ( boardCopy , player )):
                        return False
    #If we get here , we have tried all moves and it is checkmate
    return True
# Checks if there should be any promotions , and if so do them . This function always makes queens
def promotionCheck (board , player ):
    pieces = None
    y = 0
    if ( player == 1):
        y = 7
        pieces = wpieces
    else :
        y = 0
        pieces = bpieces
    for x in range (0, 8):
        # Check if any pawns has reached the opposite side of the board , and make them into queens
        if ( board [y][x] == pieces [0]):
            board [y][x] = promotionPrompt (board , player )
            break
    return board
def promotionPrompt (board , player ):
    #Set the right piece list
    if ( player == 1):
        pieces = wpieces
    else :
        pieces = bpieces
    # Take input until it is a legal one
    while ( True ):
        wipe ()
        printBoard (board , player )
        print ("You have a promotion ! Please enter your desired piece ['que ', 'k ', 'b ', or 'r ']:")
        # Process string for checking
        ans = input (). strip ()
        ans = ans. lower ()
        # Check for valid input :
        # Queen first
        if( ans in bpieces ):
            return pieces [4]
        # Then add the padding and check for other pieces
        ans = " " + ans + " "
        if (ans in bpieces ):
            ind = bpieces . index (ans)
            return pieces [ind ]
# ################################################################
# GAME LOOP ! #
# ################################################################
# This function performs the game loop . The player parameter tells which players
# turn it is. Player must be 1 or -1.
# Board is the game board
def gameLoop (board , player ):
    wipe ()
    print ( helpText )
    input (" Press 'Enter ' to start the game !")
    gameOn = True
    while ( gameOn ):
        # Time to make a move !
        inputString = ''
        turnComplete = False
        validInput = True
        isYourPiece = True
        validMove = True
        selfCheck = False
        while (not turnComplete ):
            wipe ()
            printBoard (board , player )
            # Check if player is in check .
            if( isCheck (board , player )):
                if( isCheckMate (board , player )):
                    print (" Checkmate ! Player " + str( player ) + " Has lost !")
                    gameOn = False
                    input (" Press 'Enter ' to continue ...")
                    break ;
                    # Gameover
                else :
                    print ("You are in check !")
            # Check if input was correct
            if (not validInput ):
                print (" Invalid input ! Try again !")
            if (not isYourPiece ):
                print ("You don 't own that piece ! Try Again !")
            if (not validMove ):
                print ("You can 't move there ! Try once more ")
            if ( selfCheck ):
                print ("You can 't Make that move , you would be in check !")
            # reset variables
            validInput = True
            isYourPiece = True
            validMove = True
            selfCheck = False
            inputString = input ("\nPlayer " + str( player ) + " make a move !\n"). strip ()
            if( inputString . lower () == "help"):
                wipe ()
                print ("\n" + helpText + "\n")
                input (" Press 'Enter ' to return to the game ...")
                continue
            # Validate input from user
            validInput = validateInput ( inputString )
            if (not validInput ):
                continue
            fromPosition , toPosition = parseInputToMove ( inputString )
            # Check if player tried to move it 's own piece
            isYourPiece = ( isOwner (board , player , fromPosition [0], fromPosition [1]))
            if( not isYourPiece ):
                continue
            # Check if player made a valid move
            if( not ( toPosition in getMoves (board , player , fromPosition [0],fromPosition [1]))):
                validMove = False
                continue
            # Test move on board copy
            tempBoard = copy ( board )
            movePiece ( tempBoard , fromPosition , toPosition )
            # Check if player put itself in check
            if ( isCheck ( tempBoard , player )):
                selfCheck = True
                continue
            #If we get here , we know that the move is valid , and we make the board we tested the move on , the current valid board
            board = tempBoard
            # Check for promotions
            promotionCheck (board , player )
            # Turn is complete
            turnComplete = True
            # Swap the current player
        player *= -1
# ########################################################
# Entry Point ! The fun starts here ! #
# ########################################################
# Make a fresh board
board = newBoard ()
#The game will start on the board you put into the gameLoop function
#In this case , it is just a new game
gameLoop (board , 1)

