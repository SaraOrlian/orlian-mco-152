package orlian.earthquakes;

import java.util.List;

public class CurrentEarthquakes {

    Feature features[];

    class Properties {
        double mag;
        String place;
        long time;

        @Override
        public String toString() {
            return "Properties{" +
                    "mag=" + mag +
                    ", place='" + place + '\'' +
                    ", time=" + time +
                    '}';
        }
    }

    class Feature {
        Properties properties;
    }
/*    public class Metadata {
        private int generated;

        private String url;

        private String title;

        private int status;

        private String api;

        private int count;

        public void setGenerated(int generated) {
            this.generated = generated;
        }

        public int getGenerated() {
            return this.generated;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return this.url;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return this.status;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public String getApi() {
            return this.api;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return this.count;
        }
    }

    public class Properties {
        private double mag;

        private String place;

        private int time;

        private int updated;

        private int tz;

        private String url;

        private String detail;

        private int felt;

        private double cdi;

        private String mmi;

        private String alert;

        private String status;

        private int tsunami;

        private int sig;

        private String net;

        private String code;

        private String ids;

        private String sources;

        private String types;

        private String nst;

        private double dmin;

        private double rms;

        private int gap;

        private String magType;

        private String type;

        private String title;

        public void setMag(double mag) {
            this.mag = mag;
        }

        public double getMag() {
            return this.mag;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getPlace() {
            return this.place;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getTime() {
            return this.time;
        }

        public void setUpdated(int updated) {
            this.updated = updated;
        }

        public int getUpdated() {
            return this.updated;
        }

        public void setTz(int tz) {
            this.tz = tz;
        }

        public int getTz() {
            return this.tz;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return this.url;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDetail() {
            return this.detail;
        }

        public void setFelt(int felt) {
            this.felt = felt;
        }

        public int getFelt() {
            return this.felt;
        }

        public void setCdi(double cdi) {
            this.cdi = cdi;
        }

        public double getCdi() {
            return this.cdi;
        }

        public void setMmi(String mmi) {
            this.mmi = mmi;
        }

        public String getMmi() {
            return this.mmi;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public String getAlert() {
            return this.alert;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }

        public void setTsunami(int tsunami) {
            this.tsunami = tsunami;
        }

        public int getTsunami() {
            return this.tsunami;
        }

        public void setSig(int sig) {
            this.sig = sig;
        }

        public int getSig() {
            return this.sig;
        }

        public void setNet(String net) {
            this.net = net;
        }

        public String getNet() {
            return this.net;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }

        public String getIds() {
            return this.ids;
        }

        public void setSources(String sources) {
            this.sources = sources;
        }

        public String getSources() {
            return this.sources;
        }

        public void setTypes(String types) {
            this.types = types;
        }

        public String getTypes() {
            return this.types;
        }

        public void setNst(String nst) {
            this.nst = nst;
        }

        public String getNst() {
            return this.nst;
        }

        public void setDmin(double dmin) {
            this.dmin = dmin;
        }

        public double getDmin() {
            return this.dmin;
        }

        public void setRms(double rms) {
            this.rms = rms;
        }

        public double getRms() {
            return this.rms;
        }

        public void setGap(int gap) {
            this.gap = gap;
        }

        public int getGap() {
            return this.gap;
        }

        public void setMagType(String magType) {
            this.magType = magType;
        }

        public String getMagType() {
            return this.magType;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }
    }


    public class Geometry {
        private String type;

        private List<Double> coordinates;

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void setCoordinates(List<Double> coordinates) {
            this.coordinates = coordinates;
        }

        public List<Double> getCoordinates() {
            return this.coordinates;
        }
    }

    public class Features {
        private String type;

        private Properties properties;

        private Geometry geometry;

        private String id;

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Properties getProperties() {
            return this.properties;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public Geometry getGeometry() {
            return this.geometry;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }

    public class Root {
        private String type;

        private Metadata metadata;

        private List<Features> features;

        private List<Double> bbox;

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }

        public Metadata getMetadata() {
            return this.metadata;
        }

        public void setFeatures(List<Features> features) {
            this.features = features;
        }

        public List<Features> getFeatures() {
            return this.features;
        }

        public void setBbox(List<Double> bbox) {
            this.bbox = bbox;
        }

        public List<Double> getBbox() {
            return this.bbox;
        }
    }*/

}
