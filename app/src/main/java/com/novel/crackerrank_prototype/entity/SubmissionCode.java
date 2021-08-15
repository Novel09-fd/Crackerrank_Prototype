package com.novel.crackerrank_prototype.entity;


import java.io.Serializable;

import javax.annotation.Generated;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SubmissionCode implements Serializable, Parcelable {

    @SerializedName("stdout")
    @Expose
    private Object stdout;
    @SerializedName("time")
    @Expose
    private Object time;
    @SerializedName("memory")
    @Expose
    private Object memory;
    @SerializedName("stderr")
    @Expose
    private Object stderr;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("compile_output")
    @Expose
    private String compileOutput;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("status")
    @Expose
    private Status status;
    public final static Creator<SubmissionCode> CREATOR = new Creator<SubmissionCode>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SubmissionCode createFromParcel(android.os.Parcel in) {
            return new SubmissionCode(in);
        }

        public SubmissionCode[] newArray(int size) {
            return (new SubmissionCode[size]);
        }

    };
    private final static long serialVersionUID = -632868998756257633L;

    protected SubmissionCode(android.os.Parcel in) {
        this.stdout = ((Object) in.readValue((Object.class.getClassLoader())));
        this.time = ((Object) in.readValue((Object.class.getClassLoader())));
        this.memory = ((Object) in.readValue((Object.class.getClassLoader())));
        this.stderr = ((Object) in.readValue((Object.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
        this.compileOutput = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Object) in.readValue((Object.class.getClassLoader())));
        this.status = ((Status) in.readValue((Status.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public SubmissionCode() {
    }

    /**
     * @param memory
     * @param stdout
     * @param time
     * @param compileOutput
     * @param stderr
     * @param message
     * @param token
     * @param status
     */
    public SubmissionCode(Object stdout, Object time, Object memory, Object stderr, String token, String compileOutput, Object message, Status status) {
        super();
        this.stdout = stdout;
        this.time = time;
        this.memory = memory;
        this.stderr = stderr;
        this.token = token;
        this.compileOutput = compileOutput;
        this.message = message;
        this.status = status;
    }

    public Object getStdout() {
        return stdout;
    }

    public void setStdout(Object stdout) {
        this.stdout = stdout;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Object getMemory() {
        return memory;
    }

    public void setMemory(Object memory) {
        this.memory = memory;
    }

    public Object getStderr() {
        return stderr;
    }

    public void setStderr(Object stderr) {
        this.stderr = stderr;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCompileOutput() {
        return compileOutput;
    }

    public void setCompileOutput(String compileOutput) {
        this.compileOutput = compileOutput;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SubmissionCode.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("stdout");
        sb.append('=');
        sb.append(((this.stdout == null) ? "<null>" : this.stdout));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null) ? "<null>" : this.time));
        sb.append(',');
        sb.append("memory");
        sb.append('=');
        sb.append(((this.memory == null) ? "<null>" : this.memory));
        sb.append(',');
        sb.append("stderr");
        sb.append('=');
        sb.append(((this.stderr == null) ? "<null>" : this.stderr));
        sb.append(',');
        sb.append("token");
        sb.append('=');
        sb.append(((this.token == null) ? "<null>" : this.token));
        sb.append(',');
        sb.append("compileOutput");
        sb.append('=');
        sb.append(((this.compileOutput == null) ? "<null>" : this.compileOutput));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null) ? "<null>" : this.message));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.memory == null) ? 0 : this.memory.hashCode()));
        result = ((result * 31) + ((this.stdout == null) ? 0 : this.stdout.hashCode()));
        result = ((result * 31) + ((this.time == null) ? 0 : this.time.hashCode()));
        result = ((result * 31) + ((this.compileOutput == null) ? 0 : this.compileOutput.hashCode()));
        result = ((result * 31) + ((this.stderr == null) ? 0 : this.stderr.hashCode()));
        result = ((result * 31) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((result * 31) + ((this.token == null) ? 0 : this.token.hashCode()));
        result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubmissionCode) == false) {
            return false;
        }
        SubmissionCode rhs = ((SubmissionCode) other);
        return (((((((((this.memory == rhs.memory) || ((this.memory != null) && this.memory.equals(rhs.memory))) && ((this.stdout == rhs.stdout) || ((this.stdout != null) && this.stdout.equals(rhs.stdout)))) && ((this.time == rhs.time) || ((this.time != null) && this.time.equals(rhs.time)))) && ((this.compileOutput == rhs.compileOutput) || ((this.compileOutput != null) && this.compileOutput.equals(rhs.compileOutput)))) && ((this.stderr == rhs.stderr) || ((this.stderr != null) && this.stderr.equals(rhs.stderr)))) && ((this.message == rhs.message) || ((this.message != null) && this.message.equals(rhs.message)))) && ((this.token == rhs.token) || ((this.token != null) && this.token.equals(rhs.token)))) && ((this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status))));
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(stdout);
        dest.writeValue(time);
        dest.writeValue(memory);
        dest.writeValue(stderr);
        dest.writeValue(token);
        dest.writeValue(compileOutput);
        dest.writeValue(message);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}

