import {ErrorResponse, request} from '../request';
import {FeignBuilder, post} from "axios-feign";

class CodePayApiResponse {
    success?: boolean
    code?: string
    message?: string
    requestId?: string
}

class PayApi {
    @post("/api/v1/pay/code-pay")
    public async codePay(body: object): Promise<CodePayApiResponse | ErrorResponse> {
        throw -1;
    }
}

const payApi = new FeignBuilder(request)
    .target(PayApi);

export {payApi}