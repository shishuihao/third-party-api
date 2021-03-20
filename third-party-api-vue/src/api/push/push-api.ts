import {ErrorResponse, request} from '../request';
import {FeignBuilder, post} from "axios-feign";

class PushMessageApiResponse {
    success?: boolean
    code?: string
    message?: string
    requestId?: string
}

class PushApi {
    @post("/api/v1/push")
    public async push(body: object): Promise<PushMessageApiResponse | ErrorResponse> {
        throw -1;
    }
}

const pushApi = new FeignBuilder(request)
    .target(PushApi);

export {pushApi}