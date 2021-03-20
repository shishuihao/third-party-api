import {ErrorResponse, request} from '../request';
import {FeignBuilder, post} from "axios-feign";


class SendSmsApiResponse {
    success?: boolean
    code?: string
    message?: string
    requestId?: string
}

class SendBatchSmsApiResponse {
    success?: boolean
    code?: string
    message?: string
    requestId?: string
    sendStatuses?: []
}

class SmsApi {
    @post("/api/v1/sms")
    public async send(body: object): Promise<SendSmsApiResponse | ErrorResponse> {
        throw -1;
    }

    @post("/api/v1/sms/batch")
    public async sendBatch(body: object): Promise<SendBatchSmsApiResponse | ErrorResponse> {
        throw -1;
    }
}

const smsApi = new FeignBuilder(request)
    .target(SmsApi);

export {smsApi}