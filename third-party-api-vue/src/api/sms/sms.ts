import request from '../request';
import {FeignBuilder, post} from "axios-feign";

class SmsApi {
    @post("/api/v1/sms")
    public async send(body: object): Promise<object> {
        throw -1;
    }

    @post("/api/v1/sms/batch")
    public async sendBatch(body: object): Promise<object> {
        throw -1;
    }
}

const smsApi = new FeignBuilder(request)
    .target(SmsApi);
