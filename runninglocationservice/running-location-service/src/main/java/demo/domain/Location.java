package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

// JPA library are all in persistence, for persistence development

// Class level annotation
@AllArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "LOCATION") // Ignore name will make system match current class name
// JSON Ser
// Java Object Model
// Database: Relational Model
//      OR MAPPING: JAVA -> Database
// JSON String (JS model)
// Java Object Model
//      Jackson Library JSON serilization/deserilization
@JsonInclude(JsonInclude.Include.NON_NULL) // Only include NON_NULL value
public @Data class Location {

    enum GpsStatus{
        EXCELLENT, OK, UNRELIABLE, BAD, NOFIX, UNKNOWN;
    }

    public enum RunnerMovementType{
        STOPPED, IN_MOTION;

        public boolean isMoving(){
            return this != STOPPED;
        }
    }

    // Field level annotation
    @Id // Relation ID
    @GeneratedValue // Auto Generate ID
    private Long id;

    @Embedded // map embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_make"))
    })
    private final UnitInfo unitInfo;

    @Embedded // map embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bfr", column = @Column(name = "medical_bfr")), // Map name in column to object name 'bfr'
            @AttributeOverride(name = "fmi", column = @Column(name = "medical_fmi"))
    })
    private MedicalInfo medicalInfo;

//    @Column(name = "LAT") // Column for table
    // If no @Column, system will use variable name as column name
    private double latitude;
    private double longitude;
    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus;
    private double odometer;
    private double totalRunningTime;
    private double totalIdleTime;
    private double totalCalorieBurnt;
    private String address;
    private Date timestamp = new Date();
    private String gearProvider;
    private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
    private String serviceType;

    public Location(){
        this.unitInfo = null;
    }

    @JsonCreator
    public Location(@JsonProperty("runningID") String runningId){
        this.unitInfo = new UnitInfo(runningId);
    }

    public Location(UnitInfo unitInfo){
        this.unitInfo = unitInfo;
    }

    public String getRunningId(){
        return this.unitInfo == null? null : this.unitInfo.getRunningId();
    }

//    // Setter
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setMedicalInfo(MedicalInfo medicalInfo) {
//        this.medicalInfo = medicalInfo;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public void setHeading(String heading) {
//        this.heading = heading;
//    }
//
//    public void setGpsSpeed(double gpsSpeed) {
//        this.gpsSpeed = gpsSpeed;
//    }
//
//    public void setGpsStatus(GpsStatus gpsStatus) {
//        this.gpsStatus = gpsStatus;
//    }
//
//    public void setOdometer(double odometer) {
//        this.odometer = odometer;
//    }
//
//    public void setTotalRunningTime(double totalRunningTime) {
//        this.totalRunningTime = totalRunningTime;
//    }
//
//    public void setTotalIdleTime(double totalIdleTime) {
//        this.totalIdleTime = totalIdleTime;
//    }
//
//    public void setTotalCalorieBurnt(double totalCalorieBurnt) {
//        this.totalCalorieBurnt = totalCalorieBurnt;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public void setGearProvider(String gearProvider) {
//        this.gearProvider = gearProvider;
//    }
//
//    public void setRunnerMovementType(RunnerMovementType runnerMovementType) {
//        this.runnerMovementType = runnerMovementType;
//    }
//
//    public void setServiceType(String serviceType) {
//        this.serviceType = serviceType;
//    }
//
//    // Getter
//    public Long getId() {
//
//        return id;
//    }
//
//    public UnitInfo getUnitInfo() {
//        return unitInfo;
//    }
//
//    public MedicalInfo getMedicalInfo() {
//        return medicalInfo;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public String getHeading() {
//        return heading;
//    }
//
//    public double getGpsSpeed() {
//        return gpsSpeed;
//    }
//
//    public GpsStatus getGpsStatus() {
//        return gpsStatus;
//    }
//
//    public double getOdometer() {
//        return odometer;
//    }
//
//    public double getTotalRunningTime() {
//        return totalRunningTime;
//    }
//
//    public double getTotalIdleTime() {
//        return totalIdleTime;
//    }
//
//    public double getTotalCalorieBurnt() {
//        return totalCalorieBurnt;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public String getGearProvider() {
//        return gearProvider;
//    }
//
//    public RunnerMovementType getRunnerMovementType() {
//        return runnerMovementType;
//    }
//
//    public String getServiceType() {
//        return serviceType;
//    }
}
