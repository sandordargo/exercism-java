import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class DNA {

    private String _dna;

    DNA(String input_dna) {
        _dna = input_dna;
    }

    public int count(Character charancter_to_count) {
        throwIfNotIn(charancter_to_count);
        int character_counter = 0;
        int last_index = 0;
        while (last_index != -1) {
            last_index = _dna.indexOf(charancter_to_count, last_index);
            if (last_index != -1) {
                character_counter++;
                last_index++;
            }
        }
        return character_counter;
    }

    public Map<Character, Integer> nucleotideCounts () {
        Map<Character, Integer> nucleotids_map = new HashMap<>();
        nucleotids_map.put('A', 0);
        nucleotids_map.put('C', 0);
        nucleotids_map.put('G', 0);
        nucleotids_map.put('T', 0);
        for (Map.Entry<Character, Integer> entry : nucleotids_map.entrySet()) {
            entry.setValue(this.count(entry.getKey()));
        }
        return nucleotids_map;
    }

    private void throwIfNotIn(Character character) throws IllegalArgumentException {
        if (!"ACGT".contains(character.toString())) {
            throw new IllegalArgumentException();
        }
    }
}
