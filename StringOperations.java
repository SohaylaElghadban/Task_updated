import java.util.Arrays;

public interface StringOperations {
    String Apply(String operation);

}

class ReverseOperation implements StringOperations {
    @Override
    public String Apply(String operation) {
        return new StringBuilder(operation).reverse().toString();
    }
}

class UpperCaseOperation implements StringOperations {
    @Override
    public String Apply(String operation) {
        return operation.toUpperCase();
    }
}

class LowerCaseOperation implements StringOperations {
    @Override
    public String Apply(String operation) {
        return operation.toLowerCase();
    }
}

class SortOperation implements StringOperations {
       @Override
    public String Apply(String operation) {
        char[] chars = operation.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
class CompressionOperation implements StringOperations {
    @Override
    public String Apply(String operation) {

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i <  operation.length(); i++) {
            if ( operation.charAt(i) ==  operation.charAt(i - 1)) {
                count++;
            } else {
                compressed.append( operation.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append( operation.charAt( operation.length() - 1)).append(count);
        return compressed.toString();
    }
}


