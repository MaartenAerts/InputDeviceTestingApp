package InputDeviceTesting.uantwerpen.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by TooLate on 25/10/2015.
 */
@Entity
public class Device implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;
    @NotNull
    private String vendor;
    @NotNull
    private String version;


    public Device() {
    }

    public Device(String name, String vendor, String version) {
        this.name = name;
        this.vendor = vendor;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (getId() != device.getId()) return false;
        if (!getName().equals(device.getName())) return false;
        if (!getVendor().equals(device.getVendor())) return false;
        return getVersion().equals(device.getVersion());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getVendor().hashCode();
        result = 31 * result + getVersion().hashCode();
        return result;
    }
}
