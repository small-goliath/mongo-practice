rs.initiate(
    {
        _id: "config_rs",
        configsvr: true,
        members: [
            { _id : 0, host : "configsvr1:27017" },
            { _id : 1, host : "configsvr2:27017" },
            { _id : 2, host : "configsvr3:27017" }
        ]
    }
)
