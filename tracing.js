const { NodeTracerProvider } = require('@opentelemetry/sdk-node');
const { SimpleSpanProcessor } = require('@opentelemetry/sdk-trace-base');
const { ZipkinExporter } = require('@opentelemetry/exporter-zipkin');
const { getNodeAutoInstrumentations } = require('@opentelemetry/auto-instrumentations-node');
const { registerInstrumentations } = require('@opentelemetry/instrumentation');

// Initialize the tracer provider
const provider = new NodeTracerProvider({
    instrumentations: [getNodeAutoInstrumentations()],
});

const providet = new NodeTracerProvider

// Configure the Zipkin exporter
const exporter = new ZipkinExporter({
    url: 'http://localhost:9411/api/v2/spans', // Replace with your Zipkin endpoint
    serviceName: 'my-nodejs-service', // Replace with your service name
});

// Add the Zipkin exporter to the tracer provider
provider.addSpanProcessor(new SimpleSpanProcessor(exporter));

// Register the provider
provider.register();

// Register auto-instrumentations
registerInstrumentations({
    instrumentations: [getNodeAutoInstrumentations()],
});

console.log('Tracing initialized with Zipkin');
