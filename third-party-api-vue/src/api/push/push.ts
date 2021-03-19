import request from '../request';
import {FeignBuilder, post} from "axios-feign";

class PushApi {
    @post("/api/v1/push")
    public async push(body: object): Promise<object> {
        throw -1;
    }
}

const pushApi = new FeignBuilder(request)
    .target(PushApi);
