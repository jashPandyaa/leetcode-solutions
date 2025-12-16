class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        
        while(index < words.length){
            // Determine how many words fit in current line
            int count = words[index].length();
            int last = index + 1;
            while(last < words.length){
                if(count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1; // Number of gaps between words

            // Last line or single word: left-justify
            if(last == words.length || diff == 0){
                for(int i = index + 1; i < last; i++){
                    builder.append(" ");
                    builder.append(words[i]);
                }
                // Pad remaining spaces at end
                for(int i = builder.length(); i < maxWidth; i++){
                    builder.append(" ");
                }
            }else{
                // Middle lines: fully justify
                int spaces = (maxWidth - count) / diff;        // Base spaces per gap
                int extraSpaces = (maxWidth - count) % diff;   // Extra spaces for left gaps

                for(int i = index + 1; i < last; i++){
                    // Add base spaces + 1 original space
                    for(int s = spaces; s > 0; s--){
                        builder.append(" ");
                    }
                    // Distribute extra spaces left to right
                    if(extraSpaces > 0){
                        builder.append(" ");
                        extraSpaces--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }

            lines.add(builder.toString());
            index = last;
        }   
        return lines;
    }
}