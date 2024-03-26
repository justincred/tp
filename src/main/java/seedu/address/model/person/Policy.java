package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

/**
 * Represents a Person's policy in the address book.
 * Guarantees: immutable; is always valid
 */
public class Policy {
    public static final String EXPIRY_DATE_MESSAGE_CONSTRAINTS = "Expiry date format should be dd/mm/yyyy.";
    public static final String PREMIUM_MESSAGE_CONSTRAINTS = "Premium value should be larger than or equal 0.0$.";

    public final String value;
    public final LocalDate expiryDate;
    public final double premium;

    /**
     * Constructs a {@code Policy} without an expiry date and premium.
     * This constructor can be used if the expiry date and premium are not immediately available.
     *
     * @param policy A valid policy.
     */
    public Policy(String policy) {
        requireNonNull(policy);
        value = policy;
        this.expiryDate = null;
        this.premium = 0;
    }

    /**
            * Constructs a {@code Policy}.
            *
            * @param policy A valid policy.
            * @param expiryDate The expiry date of the policy.
     * @param premium The premium amount of the policy.
     */
    public Policy(String policy, LocalDate expiryDate, double premium) {
        requireNonNull(policy);
        value = policy;
        this.expiryDate = expiryDate;
        this.premium = premium;
    }

    /**
     * Returns true if a given string is a valid premium.
     */
    public static boolean isValidPremium(String test) {
        return Double.parseDouble(test) >= 0.0;
    }

    @Override
    public String toString() {
        return value + "_" + expiryDate + "_" + premium;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Policy otherPolicy = (Policy) other;

        if (!value.equals(otherPolicy.value)) {
            return false;
        }
        if (Double.compare(otherPolicy.premium, premium) != 0) {
            return false;
        }
        return expiryDate != null ? expiryDate.equals(otherPolicy.expiryDate) : otherPolicy.expiryDate == null;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
