package demo.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Document // Cannot use @Entity, since it's not a OR mapping. It's NOSQL mongoDB
public class SupplyLocation {

    @Id
    private String id;
    private String address1;
    private String address2;
    private String city;
    @GeoSpatialIndexed
    @JsonIgnore
    private final Point location;
    private String state;
    private String zip;
    private String type;

    @SuppressWarnings("unused")
    private SupplyLocation(){
        this.location = new Point(0.0, 0.0);
    }

    @JsonCreator
    public SupplyLocation(@JsonProperty("latitude") double latitude, @JsonProperty("longitude") double longitude) {
        this.location = new Point(longitude, latitude);
    }

    public double getLatitude() {
        return this.location.getY();
    }

    public double getLongitude() {
        return this.location.getX();
    }


}
