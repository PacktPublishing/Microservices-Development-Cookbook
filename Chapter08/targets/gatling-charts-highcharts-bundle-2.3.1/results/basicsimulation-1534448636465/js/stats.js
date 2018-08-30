var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "50",
        "ok": "0",
        "ko": "50"
    },
    "minResponseTime": {
        "total": "15",
        "ok": "-",
        "ko": "15"
    },
    "maxResponseTime": {
        "total": "146",
        "ok": "-",
        "ko": "146"
    },
    "meanResponseTime": {
        "total": "67",
        "ok": "-",
        "ko": "67"
    },
    "standardDeviation": {
        "total": "30",
        "ok": "-",
        "ko": "30"
    },
    "percentiles1": {
        "total": "66",
        "ok": "-",
        "ko": "66"
    },
    "percentiles2": {
        "total": "84",
        "ok": "-",
        "ko": "84"
    },
    "percentiles3": {
        "total": "131",
        "ok": "-",
        "ko": "131"
    },
    "percentiles4": {
        "total": "145",
        "ok": "-",
        "ko": "145"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
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
        "count": 50,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "25",
        "ok": "-",
        "ko": "25"
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
        "ok": "0",
        "ko": "50"
    },
    "minResponseTime": {
        "total": "15",
        "ok": "-",
        "ko": "15"
    },
    "maxResponseTime": {
        "total": "146",
        "ok": "-",
        "ko": "146"
    },
    "meanResponseTime": {
        "total": "67",
        "ok": "-",
        "ko": "67"
    },
    "standardDeviation": {
        "total": "30",
        "ok": "-",
        "ko": "30"
    },
    "percentiles1": {
        "total": "66",
        "ok": "-",
        "ko": "66"
    },
    "percentiles2": {
        "total": "84",
        "ok": "-",
        "ko": "84"
    },
    "percentiles3": {
        "total": "131",
        "ok": "-",
        "ko": "131"
    },
    "percentiles4": {
        "total": "145",
        "ok": "-",
        "ko": "145"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
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
        "count": 50,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "25",
        "ok": "-",
        "ko": "25"
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
