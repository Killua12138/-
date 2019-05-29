package jianzhi;

import java.util.Arrays;

public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5)
            return false;
        Arrays.sort(numbers);
        int count = 0;
        for (int i : numbers) {
            if (i == 0)
                count++;
        }
        for (int i = count; i < numbers.length - 1;i++){
            int dif = numbers[i + 1] - numbers[i];
            if (dif == 0)
                return false;
            count = count - dif + 1;
        }
        return count >= 0;
    }
}
