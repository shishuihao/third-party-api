export default {
    // 菜单
    "api": "Api",
    "channel": "Channel",
    "clearing": "Clearing",
    "configuration": "Configuration",
    "pay": "Pay",
    "reconciliation": "Reconciliation",
    "report": "Report",
    "transaction": "Transaction",
    "user": "User",
    // 通用字段
    "index": "Index",
    "id": "ID",
    "gmt_create": "Create Time",
    "gmt_modified": "Modified Time",
    "type": "Type",
    "status": "Status",
    // action
    "add": "Add",
    "edit": "Edit",
    "remove": "Remove",
    "import": "Import",
    "export": "Export",
    // input
    "please enter": "Please enter",
    // fields
    "channels": {
        "alipay": {
            "name": "alipay",
            "properties": {
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
            },
        },
    },
    "configurations": {
        "properties": "properties",
    },
    "users": {
        "username": "username",
        "nickname": "nickname",
        "change password": "change password",
    },
}