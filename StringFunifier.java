import java.util.*;

public class StringFunifier {
    private String inputString;
    private List<Integer> startIndexes;
    private List<Integer> endIndexes;
    private List<StringOperations> operations;

    public StringFunifier(String inputString, List<Integer> startIndexes, List<Integer> endIndexes, List<StringOperations> operations) {
        this.inputString = inputString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
        this.operations = operations;
    }

    public String getFunnyString() {
        StringBuilder result = new StringBuilder();
        int previousEnd = 0;

        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);
            StringOperations operation = operations.get(i);

            result.append(inputString, previousEnd, start);

            String substring = inputString.substring(start, end + 1);
            String modifiedSubstring = operation.Apply(substring);

            result.append('(').append(modifiedSubstring).append(')');

            previousEnd = end + 1;
        }

        result.append(inputString, previousEnd, inputString.length());

        return result.toString();
    }


}
