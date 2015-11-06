package InputDeviceTesting.uantwerpen.conversion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Created by Niels on 6/11/2015.
 * Zien dat de Db de data kent doro de converter annotatie moete we bij de modells of het aanmake niets doen
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
    }
}