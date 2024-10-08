package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's Id in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidId(String)}
 */
public class Id {
    public final String value;

    /**
     *  Construct id
     * @param id
     */
    public Id(String id) {
        requireNonNull(id);
        /*
        checkArgument(isValidId(id), MESSAGE_CONSTRAINTS);

         */
        this.value = id;
    }
    public static boolean isValidId(String test) {
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Id)) {
            return false;
        }

        Id otherId = (Id) other;
        return value.equals(otherId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
