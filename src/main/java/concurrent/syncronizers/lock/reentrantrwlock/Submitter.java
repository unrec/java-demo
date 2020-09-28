package concurrent.syncronizers.lock.reentrantrwlock;

import org.apache.commons.lang3.StringUtils;
import java.util.Random;

public enum Submitter {
    ALICE,
    BOB,
    CAROL,
    TED;

    static Random random = new Random();

    public static Submitter getRandom() {
        return values()[random.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return StringUtils.capitalize(this.name().toLowerCase());
    }
}