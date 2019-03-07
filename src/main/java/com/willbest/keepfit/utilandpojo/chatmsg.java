package com.willbest.keepfit.utilandpojo;

import lombok.Data;

@Data
public class chatmsg {
    private Long courseid;
    private String sendphonenum;
    private String getphonenum;
    private String dealstate;

    public chatmsg(Long courseid, String sendphonenum, String getphonenum, String dealstate) {
        this.courseid = courseid;
        this.sendphonenum = sendphonenum;
        this.getphonenum = getphonenum;
        this.dealstate = dealstate;

    }
}
