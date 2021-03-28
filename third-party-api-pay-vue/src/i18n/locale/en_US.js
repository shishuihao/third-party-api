export default {
    actions: {
        "add": "Add",
        "edit": "Edit",
        "remove": "Remove",
        "import": "Import",
        "export": "Export",
        "refresh": "Refresh",
        "reset": "Reset",
        "search": "Search",
    },
    columns: {
        "index": "Index",
        "id": "ID",
        "gmt_create": "Create Time",
        "gmt_modified": "Modified Time",
        "type": "Type",
        "name": "Name",
        "status": "Status",
        "action": "Action",
    },
    statuses: {
        "ENABLED": "Enabled",
        "DISABLED": "Disabled",
    },
    placeholders: {
        "please-enter": "Please Enter ",
    },
    properties: {
        alipay: {
            "name": "alipay",
            "protocol": "communication protocol",
            "gatewayHost": "gateway host",
            "appId": "app ID",
            "signType": "sign type",
            "alipayPublicKey": "alipay public key",
            "merchantPrivateKey": "merchant private key",
            "merchantCertPath": "merchant public key cert file path",
            "alipayCertPath": "alipay public key cert path",
            "alipayRootCertPath": "alipay root cert path",
            "notifyUrl": "async notify callback url(optional)",
            "encryptKey": "AES encrypt key(optional)",
            "signProvider": "sign provider name(optional)",
            "httpProxy": "http proxy address(optional)",
            "ignoreSsl": "ignore SSL(optional)",
        },
        icbc: {
            "name": "icbc",
            "appId": "app ID",
            "privateKey": "app private key",
            "signType": "sign type",
            "charset": "charset",
            "format": "request params format",
            "icbcPublicKey": "gateway public key",
            "encryptType": "encrypt type",
            "encryptKey": "encrypt key",
            "ca": "[CA]cert public key",
            "password": "[CA]cert password",
            "emSignIp": "[EM]sign IP",
            "emSignPort": "[EM]sign port",
            "emProduct": "[EM]product",
        }
    },
    channels: {
        title: "Channel",
        columns: {},
    },
    clearings: {
        title: "Clearing",
    },
    configurations: {
        title: "Configuration",
        columns: {
            "channelId": "Channel ID",
            "propertiesId": "Properties ID",
            "properties": "Properties",
        },
    },
    reconciliations: {
        title: "Reconciliation",
    },
    reports: {
        title: "Report",
    },
    transactions: {
        title: "Transaction",
    },
    users: {
        title: "User",
        columns: {
            "username": "Username",
            "nickname": "Nickname",
        },
        actions: {
            "change-password": "Change Password",
        },
        types: {
            "admin": "Admin",
            "user": "User",
        },
    },
    about: {
        title: "About",
    },
    home: {
        title: "Home",
    }
}