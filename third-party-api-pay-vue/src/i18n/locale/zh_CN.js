export default {
    actions: {
        "add": "添加",
        "edit": "编辑",
        "remove": "移除",
        "import": "导入",
        "export": "导出",
        "refresh": "刷新",
        "reset": "重置",
        "search": "搜索",
    },
    columns: {
        "index": "序号",
        "id": "标识",
        "gmt_create": "创建时间",
        "gmt_modified": "修改时间",
        "type": "类型",
        "name": "名称",
        "status": "状态",
        "action": "操作",
    },
    statuses: {
        "ENABLED": "启用",
        "DISABLED": "禁用",
    },
    placeholders: {
        "please-enter": "请输入",
    },
    properties: {
        alipay: {
            "name": "支付宝",
            "protocol": "通信协议",
            "gatewayHost": "网关域名",
            "appId": "应用Id",
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
        icbc: {
            "name": "中国工商银行",
            "appId": "应用Id",
            "privateKey": "应用私钥",
            "signType": "签名类型",
            "charset": "字符集",
            "format": "请求参数格式",
            "icbcPublicKey": "网关公钥",
            "encryptType": "加密类型",
            "encryptKey": "加密密钥",
            "ca": "[CA]证书公钥",
            "password": "[CA]证书密码",
            "emSignIp": "[EM]签名IP",
            "emSignPort": "[EM]签名端口",
            "emProduct": "[EM]产品",
        }
    },
    channels: {
        title: "渠道",
        columns: {},
    },
    clearings: {
        title: "清账",
    },
    configurations: {
        title: "配置",
        columns: {
            "channelId": "渠道标识",
            "propertiesId": "属性标识",
            "properties": "属性",
        },
    },
    reconciliations: {
        title: "对账",
    },
    reports: {
        title: "报表",
    },
    transactions: {
        title: "交易",
    },
    users: {
        title: "用户",
        columns: {
            "username": "用户名",
            "nickname": "昵称",
        },
        actions: {
            "change-password": "修改密码",
        },
        types: {
            "admin": "管理员",
            "user": "用户",
        },
    },
    about: {
        title: "关于",
    },
    home: {
        title: "首页",
    }
}