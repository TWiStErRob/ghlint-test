package net.twisterrob.ghlint.rules

import net.twisterrob.ghlint.model.Job
import net.twisterrob.ghlint.rule.Issue
import net.twisterrob.ghlint.rule.Reporting
import net.twisterrob.ghlint.rule.VisitorRule
import net.twisterrob.ghlint.rule.report

public class MissingJobTimeoutRule : VisitorRule {

	override val issues: List<Issue> = listOf(MissingJobTimeout)

	override fun visitNormalJob(reporting: Reporting, job: Job.NormalJob) {
		super.visitNormalJob(reporting, job)
		if (job.timeoutMinutes == null) {
			reporting.report(MissingJobTimeout, job) { "${it} must have timeout-minutes." }
		}
	}

	internal companion object {

		val MissingJobTimeout =
			Issue("MissingJobTimeout", "Jobs must have timeout.")
	}
}
