export default {
    // 菜单
    "api": "API",
    "channel": "渠道",
    "clearing": "清账",
    "configuration": "配置",
    "pay": "支付",
    "reconciliation": "对账",
    "report": "报表",
    "transaction": "交易",
    "user": "用户",
    // 通用字段
    "index": "序号",
    "id": "标识",
    "gmt_create": "创建时间",
    "gmt_modified": "修改时间",
    "type": "类型",
    "status": "状态",
    // 操作
    "add": "添加",
    "edit": "编辑",
    "remove": "移除",
    "import": "导入",
    "export": "导出",
    // 输入
    "please enter": "请输入",
    // 字段
    "channels": {
        "alipay": {
            "name": "支付宝",
            "properties": {
                "protocol": "通信协议",
                "gatewayHost": "网关域名",
                "appId": "AppId",
                "signType": "签名类型",
                "alipayPublicKey": "支付宝公钥",
                "merchantPrivateKey": "应用私钥",
                "merchantCertPath": "应用公钥证书文件路径",
                "alipayCertPath": "支付宝公钥证书文件路径",
                "alipayRootCertPath": "支付宝根证书文件路径",
                "notifyUrl": "异步通知回调地址（可选）",
                "encryptKey": "AES密钥（可选）",
                "signProvider": "签名提供方的名称(可选)",
                "httpProxy": "代理地址（可选）",
                "ignoreSsl": "忽略证书校验（可选）",
            },
        },
    },
    "configurations": {
        "properties": "属性",
    },
    "users": {
        "username": "用户名",
        "nickname": "昵称",
        "change password": "修改密码",
    },
}