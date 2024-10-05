const express = require('express');
const {
  Tracer,
  BatchRecorder,
  jsonEncoder: { JSON_V2 }
} = require('zipkin');
const { HttpLogger } = require('zipkin-transport-http');
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;
const CLSContext = require('zipkin-context-cls');

// Initialize Zipkin components
const zipkinBaseUrl = 'http://localhost:9411'; // Your Zipkin server URL
const serviceName = 'sampleRequest'; // Change this to your service's name

// HTTP Logger for reporting trace data to Zipkin
const zipkinRecorder = new BatchRecorder({
  logger: new HttpLogger({
    endpoint: `${zipkinBaseUrl}/api/v2/spans`,
    jsonEncoder: JSON_V2
  })
});

// Create a tracer instance with CLSContext
const tracer = new Tracer({
  ctxImpl: new CLSContext('zipkin'), // Fix: Correctly define CLSContext
  recorder: zipkinRecorder,
  localServiceName: serviceName
});

// Initialize Express application
const app = express();

// Add Zipkin middleware
app.use(zipkinMiddleware({ tracer }));

// Example routes
app.get('/some-route', (req, res) => {
  res.send('Service 2...........');
});

// Start the server
app.listen(3001, () => {
  console.log('Server running on http://localhost:3000');
});
