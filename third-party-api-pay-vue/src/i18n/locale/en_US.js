export default {
    actions: {
        "add": "Add",
        "edit": "Edit",
        "remove": "Remove",
        "import": "Import",
        "export": "Export",
    },
    columns: {
        "index": "Index",
        "id": "ID",
        "gmt_create": "Create Time",
        "gmt_modified": "Modified Time",
        "type": "Type",
        "name": "Name",
        "status": "Status",
    },
    placeholders: {
        "please-enter": "Please enter ",
    },
    properties: {
        alipay: {
            "name": "alipay",
            "protocol": "communication protocol",
            "gatewayHost": "gateway host",
            "appId": "AppId",
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
        }
    },
    about: {
        title: "About",
    },
    home: {
        title: "Home",
    }
}