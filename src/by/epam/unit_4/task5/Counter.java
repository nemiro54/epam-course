package by.epam.unit_4.task5;

public class Counter {
    private int currCount;
    private final int beginCount;
    private final int endCount;

    public Counter(){
        currCount = 0;
        beginCount = 0;
        endCount = 0;
    }

    public Counter(int currCount, int beginCount, int endCount) {
        if (currCount >= beginCount && currCount <= endCount) {
            this.currCount = currCount;
        } else {
            this.currCount = beginCount;
        }

        this.beginCount = beginCount;
        this.endCount = endCount;
    }

    public void increase() {
        if (currCount >= beginCount && currCount < endCount) {
            currCount++;
        }
    }

    public void decrease() {
        if (currCount > beginCount && currCount <= endCount) {
            currCount--;
        }
    }

    public int getCurrCount() {
        return currCount;
    }

    public int getBeginCount() {
        return beginCount;
    }

    public int getEndCount() {
        return endCount;
    }

    @Override
    public String toString() {
        return String.format("Диапазон счетчика: %d - %d\nТекущее значение: %d", beginCount, endCount, currCount);
    }
}
