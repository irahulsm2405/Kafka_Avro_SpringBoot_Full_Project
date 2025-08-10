Producer changes:

- add avro dependency
- create a new value serializer, custom class
- update full serializer class name in properties file
- add avro reader property in properties file
- update sendEmployeeEvent to send the emplyeeId as a string
- update mapToEvent methods to now map to avro event