namespace java com.undercarriage.helloworld.thriftjava
#@namespace scala com.undercarriage.helloworld.thriftscala

struct HelloWorldRequest {
  1: optional string message;
}

struct HelloWorldResponse {
  1: optional string response;
}

service HelloWorldService {
  HelloWorldResponse toUpperCase(
    1: HelloWorldRequest request
  )
}

