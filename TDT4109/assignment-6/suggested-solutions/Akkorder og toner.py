# Question a)

triad_types = ['aug', 'dim', 'm']

def get_undertone(chord):
    for t in triad_types:
        if t in chord:
            split = len(t)
            
            # Slice chord at index 'split'
            root = chord[:-split]        # equivalent to chord[:len(chord)-split]
            triad_type = chord[-split:]  # equivalent to chord[len(chord)-split:]
            return root, triad_type
    
    # If none of the previous types, must be a major
    return chord, ''


# Question b)

sharp_tones = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
flat_tones = ['C', 'Db', 'D', 'Eb', 'E', 'F', 'Gb', 'G', 'Ab', 'A', 'Bb', 'B']

def get_tone_list(chord):
    right_major_keys = ['C', 'G', 'D', 'A', 'E', 'B', 'F#']
    root, triad_type = get_undertone(chord)
    
    # Check minors (inner circle)
    if triad_type == 'm':
        if root in ['D', 'G', 'C', 'F']: # left half
            return flat_tones
        else:
            return sharp_tones
    
    # Not minor
    if root in right_major_keys:
        return sharp_tones
    else:
        return flat_tones

# Question c)

major = (4, 3)
minor = (3, 4)
dim = (3, 3)
aug = (4, 4)

# Make new list matching triads to their equivalent tuples
triads = ['aug', 'dim', 'm', '']
triad_equivalent = [aug, dim, minor, major] # tuples with positions of the next notes

def chord_notes(chord):
    root, triad_type = get_undertone(chord)
    tone_list = get_tone_list(chord)
    notes = []
    
    note_index = tone_list.index(root) # get position of root of the chord
    notes.append(tone_list[note_index])
    
    triad_type_index = triads.index(triad_type) # index of tuple
    triad_next_notes = triad_equivalent[triad_type_index] # get tuple of next note positions
    
    for next_pos in triad_next_notes:
        note_index = (note_index + next_pos) % len(tone_list) # increase index to find next notes, loop if necessary
        notes.append(tone_list[note_index])
        
    return notes

# Question c) with dictionaries

major = (4, 3)
minor = (3, 4)
dim = (3, 3)
aug = (4, 4)
triad_types = ['aug', 'dim', 'm']

# Use dictionaries
triad_map = {
    '': major,
    'm': minor,
    'dim': dim,
    'aug': aug
}

def chord_notes(chord):
    root, triad_type = get_undertone(chord)
    tone_list = get_tone_list(chord)
    notes = []
    
    note_index = tone_list.index(root) # get position of root of the chord
    notes.append(tone_list[note_index])

    for next_pos in triad_map[triad_type]:
        note_index = (note_index + next_pos) % len(tone_list) # increase index to find next notes, loop if necessary
        notes.append(tone_list[note_index])
        
    return notes