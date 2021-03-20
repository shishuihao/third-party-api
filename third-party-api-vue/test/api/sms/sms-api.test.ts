import {smsApi} from '../../../src/api/sms/sms-api';
import {ErrorResponse} from "../../../src/api/request";

test('send sms test', () => {
    return smsApi.send({
        "channelId": "sms.aliyun",
        "propertiesId": "AccessKeyId",
        "templateId": "SMS_123456789",
        "message": {
            "phoneNumber": "8613711112222",
            "signName": "test",
            "templateParams": {
                "code": "12345"
            }
        }
    }).then(data => {
        if (data instanceof ErrorResponse) {
            expect(data.status).toBe(500);
            expect(data.error).toMatch("Internal Server Error");
            expect(data.message).toMatch("");
            expect(data.path).toMatch("/api/v1/sms");
        }
    })
});
