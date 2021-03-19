import request from '../request';
import {FeignBuilder, post} from "axios-feign";

class PayApi {
    @post("/api/v1/pay/code-pay")
    public async codePay(body: object): Promise<object> {
        throw -1;
    }
}

const payApi = new FeignBuilder(request)
    .target(PayApi);
