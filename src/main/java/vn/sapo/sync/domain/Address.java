package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "address")
public class Address extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("address1")
    private String address1;

    @Field("address2")
    private String address2;

    @Field("city")
    private String city;

    @Field("company")
    private String company;

    @Field("country")
    private String country;

    @Field("first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Field("last_name")
    @JsonProperty("last_name")
    private String lastName;

    @Field("phone")
    private String phone;

    @Field("district")
    private String district;

    @Field("district_code")
    @JsonProperty("district_code")
    private String districtCode;

    @Field("province")
    private String province;

    @Field("province_code")
    @JsonProperty("province_code")
    private String provinceCode;

    @Field("zip")
    private String zip;

    @Field("country_code")
    @JsonProperty("country_code")
    private String countryCode;

    @Field("country_name")
    @JsonProperty("country_name")
    private String countryName;

    @Field("name")
    private String name;

    @Field("default")
    @JsonProperty("default")
    private boolean defaultAdd;

    @Field("latitude")
    private Double latitude;

    @Field("longitude")
    private Double longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultAdd() {
        return defaultAdd;
    }

    public void setDefaultAdd(boolean defaultAdd) {
        this.defaultAdd = defaultAdd;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
