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
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "226",
        "ok": "226",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "40",
        "ok": "40",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "percentiles1": {
        "total": "14",
        "ok": "14",
        "ko": "-"
    },
    "percentiles2": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "percentiles3": {
        "total": "169",
        "ok": "169",
        "ko": "-"
    },
    "percentiles4": {
        "total": "208",
        "ok": "208",
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
"req_createmessage-3d6e1": {
        type: "REQUEST",
        name: "createMessage",
path: "createMessage",
pathFormatted: "req_createmessage-3d6e1",
stats: {
    "name": "createMessage",
    "numberOfRequests": {
        "total": "50",
        "ok": "50",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "14",
        "ok": "14",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "226",
        "ok": "226",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "76",
        "ok": "76",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "60",
        "ok": "60",
        "ko": "-"
    },
    "percentiles1": {
        "total": "44",
        "ok": "44",
        "ko": "-"
    },
    "percentiles2": {
        "total": "118",
        "ok": "118",
        "ko": "-"
    },
    "percentiles3": {
        "total": "199",
        "ok": "199",
        "ko": "-"
    },
    "percentiles4": {
        "total": "217",
        "ok": "217",
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
    },"req_getmessage-ae74b": {
        type: "REQUEST",
        name: "getMessage",
path: "getMessage",
pathFormatted: "req_getmessage-ae74b",
stats: {
    "name": "getMessage",
    "numberOfRequests": {
        "total": "50",
        "ok": "50",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "14",
        "ok": "14",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "5",
        "ok": "5",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "3",
        "ok": "3",
        "ko": "-"
    },
    "percentiles1": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "percentiles2": {
        "total": "7",
        "ok": "7",
        "ko": "-"
    },
    "percentiles3": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles4": {
        "total": "13",
        "ok": "13",
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
