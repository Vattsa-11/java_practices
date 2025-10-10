public class Q7_VotingSystem {
    
    public void processVote(String voterId, String candidate) {
        // Local Inner Class: VoteValidator
        class VoteValidator {
            public boolean validate() {
                // Check if voterId is valid (simple check: not null and not empty)
                if (voterId != null && !voterId.isEmpty() && voterId.length() >= 5) {
                    return true;
                }
                return false;
            }
        }
        
        VoteValidator validator = new VoteValidator();
        
        if (validator.validate()) {
            System.out.println("Vote accepted for Voter ID: " + voterId + " -> Candidate: " + candidate);
        } else {
            System.out.println("Invalid Voter ID: " + voterId + " - Vote rejected!");
        }
    }
    
    public static void main(String[] args) {
        Q7_VotingSystem votingSystem = new Q7_VotingSystem();
        
        // Call processVote with various voterIds
        votingSystem.processVote("V12345", "Candidate A");
        votingSystem.processVote("V67890", "Candidate B");
        votingSystem.processVote("V123", "Candidate C");
        votingSystem.processVote("", "Candidate D");
        votingSystem.processVote(null, "Candidate E");
    }
}
