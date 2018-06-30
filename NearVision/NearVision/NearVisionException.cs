using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NearVision
{
    [Serializable()]
    public class NearVisionException : System.Exception
    {
        public NearVisionException() : base() { }
        public NearVisionException(string message) : base(message) { }
        public NearVisionException(string message, System.Exception inner) : base(message, inner) { }

        // A constructor is needed for serialization when an
        // exception propagates from a remoting server to the client. 
        protected NearVisionException(System.Runtime.Serialization.SerializationInfo info,
            System.Runtime.Serialization.StreamingContext context)
        { }
    }
}
