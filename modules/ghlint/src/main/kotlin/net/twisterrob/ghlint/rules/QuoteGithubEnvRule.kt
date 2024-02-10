package net.twisterrob.ghlint.rules

import net.twisterrob.ghlint.model.Step
import net.twisterrob.ghlint.rule.Issue
import net.twisterrob.ghlint.rule.Reporting
import net.twisterrob.ghlint.rule.VisitorRule

public class QuoteGithubEnvRule : VisitorRule {

	override fun visitRunStep(reporting: Reporting, step: Step.Run) {
		super.visitRunStep(reporting, step)
		if (step.run.contains(GITHUB_ENV_REGEX)) {
			reporting.report(QuoteGithubEnv, step) { "${it} must be quoted." }
		}
	}

	internal companion object {

		private val GITHUB_ENV_REGEX = Regex("""(?<!")\$(?!\{)GITHUB_ENV(?!")""")

		val QuoteGithubEnv =
			Issue("QuoteGithubEnv", "GITHUB_ENV must be quoted.")
	}
}
