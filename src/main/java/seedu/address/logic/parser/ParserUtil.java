package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.DateUtil.DATE_FORMATTER;
import static seedu.address.commons.util.DateUtil.DATE_TIME_FORMATTER;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.ScheduleDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Diagnosis;
import seedu.address.model.person.Email;
import seedu.address.model.person.Id;
import seedu.address.model.person.Medication;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Ward;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String Id} into a {@code Id}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code id} is invalid.
     */
    public static Id parseId(String id) throws ParseException {
        requireNonNull(id);
        String trimmedId = id.trim();
        if (!Id.isValidId(trimmedId)) {
            throw new ParseException(Id.MESSAGE_CONSTRAINTS);
        }
        return new Id(trimmedId);
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String Ward} into a {@code Ward}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code ward} is invalid.
     */
    public static Ward parseWard(String ward) throws ParseException {
        requireNonNull(ward);
        String trimmedWard = ward.trim();
        if (!Ward.isValidWard(trimmedWard)) {
            throw new ParseException(Ward.MESSAGE_CONSTRAINTS);
        }
        return new Ward(trimmedWard);
    }

    /**
     * Parses a {@code String Diagnosis} into a {@code Diagnosis}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code diagnosis} is invalid.
     */
    public static Diagnosis parseDiagnosis(String diagnosis) throws ParseException {
        requireNonNull(diagnosis);
        String trimmedDiagnosis = diagnosis.trim();
        if (!Diagnosis.isValidDiagnosis(trimmedDiagnosis)) {
            throw new ParseException(Diagnosis.MESSAGE_CONSTRAINTS);
        }
        return new Diagnosis(trimmedDiagnosis);
    }

    /**
     * Parses a {@code String Medication} into a {@code Medication}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code medication} is invalid.
     */
    public static Medication parseMedication(String medication) throws ParseException {
        requireNonNull(medication);
        String trimmedMedication = medication.trim();
        if (!Medication.isValidMedication(trimmedMedication)) {
            throw new ParseException(Medication.MESSAGE_CONSTRAINTS);
        }
        return new Medication(trimmedMedication);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String appointmentDescription} into a {@code String appointmentDescription}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code appointmentDescription} is empty.
     */
    public static String parseAppointmentDescription(String appointmentDescription) throws ParseException {
        requireNonNull(appointmentDescription);
        String trimmedAppointmentDescription = appointmentDescription.trim();
        if (trimmedAppointmentDescription.isEmpty()) {
            throw new ParseException("Appointment description cannot be empty.");
        }
        return trimmedAppointmentDescription;
    }

    /**
     * Parses a {@code String dateTime} into a {@code localDateTime}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code dateTime} is invalid.
     */
    public static LocalDateTime parseLocalDateTime(String dateTime) throws ParseException {
        requireNonNull(dateTime);
        String trimmedDateTime = dateTime.trim();
        try {
            return LocalDateTime.parse(trimmedDateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new ParseException("Invalid date-time format: " + trimmedDateTime, e);
        }
    }

    /**
     * Parses a {@code String date} into a {@code localDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code date} is invalid.
     */
    public static LocalDate parseLocalDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        try {
            return LocalDate.parse(trimmedDate, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ScheduleDateCommand.MESSAGE_USAGE), e);
        }
    }

}
