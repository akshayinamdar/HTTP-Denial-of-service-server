# HTTP-Denial-of-service-server
# Simple Java CLI HTTP Denial-of-Service protection system server
- - - -
1. An HTTP server, using Spring Boot
	Endpoint that for each incoming HTTP request does the following:
      1.  Check if this specific client reached the max number of requests per time frame threshold (no more than 5 requests per 5 secs).
      2.  If the client has not reached the threshold, it will return 200 OK response otherwise 503 Service Unavailable is returned
      3.  The time frame starts on each client's first request and ends 5 seconds later. After the time frame has ended, the client's first request will open a new time frame and so forth.
     
