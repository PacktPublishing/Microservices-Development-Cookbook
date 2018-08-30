var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "32",
        "ok": "32",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "31",
        "ok": "31",
        "ko": "-"
    },
    "percentiles1": {
        "total": "24",
        "ok": "24",
        "ko": "-"
    },
    "percentiles2": {
        "total": "47",
        "ok": "47",
        "ko": "-"
    },
    "percentiles3": {
        "total": "95",
        "ok": "95",
        "ko": "-"
    },
    "percentiles4": {
        "total": "139",
        "ok": "139",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 100,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "50",
        "ko": "-"
    }
},
contents: {
"req_main-createmess-22998": {
        type: "REQUEST",
        name: "main createMessage",
path: "main createMessage",
pathFormatted: "req_main-createmess-22998",
stats: {
    "name": "main createMessage",
    "numberOfRequests": {
        "total": "50",
        "ok": "50",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "19",
        "ok": "19",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "29",
        "ok": "29",
        "ko": "-"
    },
    "percentiles1": {
        "total": "47",
        "ok": "47",
        "ko": "-"
    },
    "percentiles2": {
        "total": "62",
        "ok": "62",
        "ko": "-"
    },
    "percentiles3": {
        "total": "122",
        "ok": "122",
        "ko": "-"
    },
    "percentiles4": {
        "total": "140",
        "ok": "140",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 50,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "25",
        "ok": "25",
        "ko": "-"
    }
}
    },"req_main-getmessage-4c3d0": {
        type: "REQUEST",
        name: "main getMessage",
path: "main getMessage",
pathFormatted: "req_main-getmessage-4c3d0",
stats: {
    "name": "main getMessage",
    "numberOfRequests": {
        "total": "50",
        "ok": "50",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "37",
        "ok": "37",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "10",
        "ok": "10",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "7",
        "ok": "7",
        "ko": "-"
    },
    "percentiles1": {
        "total": "8",
        "ok": "8",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13",
        "ok": "13",
        "ko": "-"
    },
    "percentiles3": {
        "total": "24",
        "ok": "24",
        "ko": "-"
    },
    "percentiles4": {
        "total": "32",
        "ok": "32",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 50,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "25",
        "ok": "25",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
