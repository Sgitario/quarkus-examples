package acme.beamparams;

import jakarta.ws.rs.FormParam;

public class BeanWithFormParams {
    private final String param1;
    private final String param2;
    private final Param param3;

    public BeanWithFormParams(String param1, String param2, Param param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    @FormParam("param1")
    public String getParam1() {
        return param1;
    }

    @FormParam("param2")
    public String getParam2() {
        return param2;
    }

    @FormParam("param3")
    public Param getParam3() {
        return param3;
    }
}
